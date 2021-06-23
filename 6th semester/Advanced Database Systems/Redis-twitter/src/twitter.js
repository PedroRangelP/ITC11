const redis = require('redis')
const chalk = require('chalk')
const { promisify } = require('util')

// Default client values: port 6379, host: localhost
let client = redis.createClient()

// Binding redis callbacks to promises 
const alindex = promisify(client.lindex).bind(client)
const allen = promisify(client.llen).bind(client)
const asubscribe = promisify(client.subscribe).bind(client)
const aset = promisify(client.set).bind(client)
const aget = promisify(client.get).bind(client)
const aexists = promisify(client.exists).bind(client)
const arpush = promisify(client.rpush).bind(client)
const ahget = promisify(client.hget).bind(client)
const ahmset = promisify(client.hmset).bind(client)

client.on('connect', () => {
    console.log(chalk.bgGreen.bold.black('Connected to redis'));
});

// Register user
const registerUser = async (username, password, name) => {
    const reply = await ahmset(username, "password", password, "name", name)

    if(reply === "OK")
        console.log(chalk.green("User registed sucessfully"));
    else
        console.log(chalk.red("Fail to register user"));
    client.quit();
}

// Login user
const loginUser = async (username, password) => {
    const reply = await ahget(username, "password")

    if(reply === password){
        console.log(chalk.green("Logged in"));
        await aset("loggedUser", username);
    }else
        console.log(chalk.red("Wrong username or password"));  
    client.quit();
}

// Follow user
const followUser = async (username) => {
    const loggedUser = await aget("loggedUser")

    if(loggedUser !== ""){
        const reply = await aexists(username)
        
        if (reply == 1){
            let temp = loggedUser + "Following";
            await arpush(temp, username);
            console.log(chalk.green("You started following " + username));
        }
        else 
            console.log(chalk.red("Cant find that username"));
        
        client.quit();
    }else
        console.log(chalk.red("You are not logged in"));
}

// Make a tweet from an account
const tweet = async (body) => {
    const loggedUser = await aget("loggedUser")

    if(loggedUser !== ""){
        let temp = loggedUser + "Tweets"
        client.publish(temp, body)
        client.quit();
        console.log(chalk.green("Tweet successfully published"));
    }
    else
        console.log(chalk.red("You are not logged in"));
}

const logout = async () => {
    await aset("loggedUser", "");
    console.log(chalk.red("Logged out"));
    client.quit();
}

// Display all my tweets

const timeline = async () => {
    const loggedUser = await aget("loggedUser")

    if(loggedUser !== ""){
        const temp = loggedUser + "Following";
        const followingLength = await allen(temp);
        let channels = []

        for(let i = 0; i < followingLength; i++) {
            let channel = await alindex(temp, i)
            channels.push(channel + "Tweets")
        }

        client.on("message", (channel, message) => {
            console.log(chalk.blue("Tweet: " + message + " by " + channel.substring(0, channel.length-6)));
        });
        
        asubscribe.apply(null, channels);
    }
    else
        console.log(chalk.red("You are not logged in"));

}

module.exports = {
    registerUser,
    loginUser,
    logout,
    followUser,
    tweet,
    timeline
}
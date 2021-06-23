const yargs = require('yargs')
const tweeter = require('./twitter.js')

// Customize yargs version
yargs.version('1.1.0')

// Register user
yargs.command({
    command: 'register',
    describe: 'register a user',
    builder: {
        username:{
            describe: 'username',
            demandOption: true,
            type: 'string'
        },
        password:{
            describe: 'password',
            demandOption: true,
            type: 'string'
        },
        name:{
            describe: 'name',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv) {
        tweeter.registerUser(argv.username, argv.password,argv.name)
    }
})


//Login
yargs.command({
    command: 'login',
    describe: 'login a user',
    builder: {
        username:{
            describe: 'username',
            demandOption: true,
            type: 'string'
        },
        password:{
            describe: 'password',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv) {
        tweeter.loginUser(argv.username,argv.password)
    }
})
//logout
yargs.command({
    command: 'logout',
    describe: 'session logout',
    handler() {
        tweeter.logout()
    }
})

//follow
yargs.command({
    command: 'follow',
    describe: 'follow a user',
    builder: {
        username:{
            describe: 'username',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv) {
        tweeter.followUser(argv.username)
    }
})

//tweet
yargs.command({
    command: 'tweet',
    describe: 'tweet',
    builder: {
        body:{
            describe: 'tweet',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv) {
        tweeter.tweet(argv.body)
    }
})

// List tweet
yargs.command({
    command: 'timeline',
    describe: 'tweets of your timeline',
    handler() {
        tweeter.timeline()
    }
})


yargs.parse()

// console.log(yargs.argv)
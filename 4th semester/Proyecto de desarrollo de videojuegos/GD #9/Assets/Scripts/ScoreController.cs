using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ScoreController : MonoBehaviour
{
    public static ScoreController instance;
    public Text[] scoreLabels;

    public static int currentScore;
    public int bestScore;

    private void Start()
    {
        instance = this;
        scoreLabels = GetComponentsInChildren<Text>();
    }

    void Update(){
        scoreLabels[0].text = "Score: " + currentScore;
    }

    public void incrementScore(int increment)
    {
        currentScore += increment;
    }

    public void compareScores(){
        if(currentScore >= bestScore)
        {
            bestScore = currentScore;
        }
        currentScore = 0;
        scoreLabels[1].text = "Best score: " + bestScore;
    }

}

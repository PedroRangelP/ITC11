using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BoardController : MonoBehaviour
{
    [Header("Tile Prefab")]
    public GameObject tile;
    private int height = 0;
    private int width = 0;
    [SerializeField] private GameObject[] board;
    

    private void Start()
    {
        GenerateBoard(3,3);
    }

    private void Update()
    {
        score=ScoreController.currentScore;
        if( score%5>1){
            height+=score%5;
            width+=score%5;
            GenerateBoard(height,width);
        }
    }
    
    public void GenerateBoard(int height, int width)
    {
        this.height = height;
        this.width = width;
        
        GameObject[] tiles = new GameObject[height*width];
        for (int i = 0; i < height*width; i++)
        {
            tiles[i] = tile;
        }
        board = tiles;

        DisplayBoard();
    }
    private void DisplayBoard()
    {
        int i = 0;
        for (int w = 0; w < width; w++)
        {
            for (int h = height; h > 0; h--)
            {
                Vector3 position = new Vector3(w-width/2, h-height, 0);
                Instantiate(board[i], position, Quaternion.identity);
                i+=1;
            }
        }
    }
}

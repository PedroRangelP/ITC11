using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TileController : MonoBehaviour
{
    private SpriteRenderer spriteRenderder;
    private bool isSelected = false;
    private RandomColor randomColor;

    private void Start()
    {
        randomColor = GetComponent<RandomColor>();
        spriteRenderder = GetComponent<SpriteRenderer>();
    }

    private void OnMouseDown()
    {
        spriteRenderder.color = randomColor.GenerateRandomColor();
    }


}

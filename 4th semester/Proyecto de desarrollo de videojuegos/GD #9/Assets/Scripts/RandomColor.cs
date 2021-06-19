using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RandomColor : MonoBehaviour
{
    public Color GenerateRandomColor()
    {
        Color NewColor;
        NewColor = new Color((Random.Range(70f,253f))/255, (Random.Range(137f,250f))/255,(Random.Range(81f,240f))/255);
        return NewColor;
    }
}

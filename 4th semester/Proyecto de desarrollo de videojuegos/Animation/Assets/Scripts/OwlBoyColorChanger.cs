using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class OwlBoyColorChanger : MonoBehaviour
{
    public void ChangeToRed()
    {
        gameObject.GetComponent<SpriteRenderer>().color = Color.red;
    }

    public void ChangeToWhite()
    {
        gameObject.GetComponent<SpriteRenderer>().color = Color.white;
    }
}

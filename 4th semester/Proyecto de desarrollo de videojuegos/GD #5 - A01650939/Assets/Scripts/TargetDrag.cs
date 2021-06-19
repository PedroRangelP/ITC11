using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TargetDrag : MonoBehaviour
{
    private bool isDragging;
    
    private void Update()
    {
        if (isDragging)
        {
            Vector2 mouseWorldPosition = Camera.main.ScreenToWorldPoint(Input.mousePosition) - gameObject.transform.position;
            gameObject.transform.Translate(mouseWorldPosition);
        }
    }

    private void OnMouseDown()
    {
        isDragging = true;
    }

    private void OnMouseUp()
    {
        isDragging = false;
    }
}

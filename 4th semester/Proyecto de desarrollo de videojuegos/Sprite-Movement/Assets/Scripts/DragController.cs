using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DragController : MonoBehaviour
{
    bool isDragging;
    
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
        //Debug.Log("El mouse se encuentra en el objeto");
    }

    private void OnMouseUp()
    {
        isDragging = false;
        //Debug.Log("El mouse salió del objeto");
    }
}

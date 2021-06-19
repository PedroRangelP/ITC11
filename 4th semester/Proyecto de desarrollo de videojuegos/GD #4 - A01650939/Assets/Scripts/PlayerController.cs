using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    private float inputX, inputY, x, y;

    private void Update()
    {
        RaycastHit2D hit;

        x = gameObject.transform.position.x;
        y = gameObject.transform.position.y;

            if (Input.GetKeyDown(KeyCode.RightArrow))
            {
                hit = Physics2D.Raycast(transform.position, Vector2.right, 1.25f, 1 <<LayerMask.NameToLayer("Tree"));
                if (hit.collider==null)
                {
                    gameObject.transform.position = new Vector3(x + 1f, y, 0);
                    gameObject.transform.rotation = Quaternion.Euler(0,0,90);
                }
            }
            
            if (Input.GetKeyDown(KeyCode.LeftArrow))
            {
                hit = Physics2D.Raycast(transform.position, -Vector2.right, 1.25f, 1 <<LayerMask.NameToLayer("Tree"));
                if (hit.collider==null)
                {
                    gameObject.transform.position = new Vector3(x - 1f, y, 0);
                    gameObject.transform.rotation = Quaternion.Euler(0,0,270);
                } 
            }
            
            if (Input.GetKeyDown(KeyCode.UpArrow))
            {
                hit = Physics2D.Raycast(transform.position, Vector2.up, 1.25f, 1 <<LayerMask.NameToLayer("Tree"));
                if (hit.collider==null)
                {
                    gameObject.transform.position = new Vector3(x, y + 1f, 0);
                    gameObject.transform.rotation = Quaternion.Euler(0,0,180);
                } 
            }
            
            if (Input.GetKeyDown(KeyCode.DownArrow))
            {
                hit = Physics2D.Raycast(transform.position, -Vector2.up, 1.25f, 1 <<LayerMask.NameToLayer("Tree"));
                if (hit.collider==null)
                {
                    gameObject.transform.position = new Vector3(x, y - 1f, 0);
                    gameObject.transform.rotation = Quaternion.Euler(0,0,0);
                } 
            }
    }

    private void OnCollisionEnter2D(Collision2D other)
    {
        if(other.gameObject.CompareTag("Enemy")) {
            gameObject.transform.position = new Vector3(0, -3.5f, 0);
        }
    }
}
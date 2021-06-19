using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DiceController : MonoBehaviour
{
    private Animator animator;
    private bool running;

    private void Start()
    {
        animator = gameObject.GetComponent<Animator>();
    }

    private void Update()
    {
        if (Input.GetKeyUp(KeyCode.Space))
        {
            running = !running;
            animator.speed = running ? 1 : 0;  
            if (!running)
            {
                Debug.Log("Stopped at " + gameObject.GetComponent<SpriteRenderer>().sprite.name);
            } 
        }
    }
}

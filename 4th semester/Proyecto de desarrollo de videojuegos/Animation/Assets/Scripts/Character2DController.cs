using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Character2DController : MonoBehaviour
{
    public Animator animator;
    public Rigidbody2D rigidbody2D;
    public float moveSpeed;

    public SpriteRenderer spriteRenderer;

    private void FixedUpdate()
    {
        float xInput = Input.GetAxis("Horizontal");

        if (xInput < 0)
        {
            spriteRenderer.flipX = true;
        }else
        {
            spriteRenderer.flipX = false;
        }
        
        float xForce = xInput * moveSpeed * Time.deltaTime;
        float yForce = rigidbody2D.velocity.y;

        Vector2 velocity = new Vector2(xForce, yForce);
        rigidbody2D.velocity = velocity;

        animator.SetFloat("VelocityX", Mathf.Abs(velocity.x));
    }
}

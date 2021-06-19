using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Character2DController : MonoBehaviour
{
    private Rigidbody2D rigidbody;
    public float moveSpeed = 100;
    public float jumpVelocity = 10;

    private void Start()
    {
        rigidbody = gameObject.GetComponent<Rigidbody2D>();
    }

    private void FixedUpdate()
    {
        float xInput = Input.GetAxis("Horizontal");
        float yInput = Input.GetAxis("Vertical");

        float xForce = xInput * moveSpeed * Time.deltaTime;
        float yForce = rigidbody.velocity.y;

        if (Input.GetKeyDown(KeyCode.Space))
        {
            yForce = jumpVelocity;
        }

        rigidbody.velocity = new Vector2(xForce, yForce);
    }
}

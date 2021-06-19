using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour {
    public float speed = 25f;
    public float maxSpeed = 5f;
    public bool grounded;
    public float jumpPower = 9.25f;
    public bool winner = false;
    private Rigidbody2D rb2d;
    private Animator anim;
    private bool jump;
    private bool doubleJump;
    
    void Start() {
        rb2d = GetComponent<Rigidbody2D>();
        anim = GetComponent<Animator>();
    }

    void Update() {
        anim.SetFloat("Speed", Mathf.Abs(rb2d.velocity.x));
        anim.SetFloat("Speed", Mathf.Abs(rb2d.velocity.y));
        anim.SetBool("Grounded", grounded);

        if(Input.GetKeyDown(KeyCode.UpArrow)){
            if(grounded){
                jump = true;
                doubleJump = true;
            }else if(doubleJump) {
                jump = true;
                doubleJump = false;
            }
        }
    }

    void FixedUpdate() {
        Vector3 fixedVelocity = rb2d.velocity;
        fixedVelocity.x *= 0.75f;
        if(grounded){
            rb2d.velocity = fixedVelocity;
        }

        if(!winner) {
            float x = Input.GetAxis("Horizontal");
            float limitedSpeed = Mathf.Clamp(rb2d.velocity.x, -maxSpeed, maxSpeed);

            rb2d.AddForce(Vector2.right*speed*x);
            rb2d.velocity = new Vector2(limitedSpeed, rb2d.velocity.y);

            if(x>0.1f){
               transform.localScale = new Vector3(1f, 1f, 1f);
            }
            if(x<-0.1f){
                transform.localScale = new Vector3(-1f, 1f, 1f);
            }

            if(jump) {
                rb2d.velocity = new Vector2(rb2d.velocity.x, 0);
                rb2d.AddForce(Vector2.up*jumpPower, ForceMode2D.Impulse);
                jump = false;
            }     
        }       
    }

    private void OnCollisionStay2D(Collision2D col) {

        if(col.gameObject.tag == "Wolf") {
            transform.position = new Vector3(-4f, -1.751f, 0f);
        }
        if(col.gameObject.tag == "Coin") {
            winner = true;
        }
    }

    private void OnBecameInvisible() {
        transform.position = new Vector3(-4f, -1.751f, 0f);
    }
}

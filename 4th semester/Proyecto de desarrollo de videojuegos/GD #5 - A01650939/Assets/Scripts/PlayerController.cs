using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    [Header("Player Settings")]
    private float speed = 92.5f;
    private float maxSpeed = 4.85f;
    private float jumpPower = 9.7f;
    private bool isGrounded;
    private bool jump;
    private bool doubleJump;
    private float yVelocity;
    private Vector3 editorPosition;

    [Header("Healthbar system")]
    public HealthbarController healthbar;
    private float life = 100f;

    private Rigidbody2D rigidbody2D;
    private Animator animator;
    private SpriteRenderer sprite;


    private void Start()
    {
        rigidbody2D = GetComponent<Rigidbody2D>();
        animator = GetComponent<Animator>();
        sprite = gameObject.GetComponent<SpriteRenderer>();
        healthbar.SetHealth(life);
    }

    private void Update()
    {
        if (!MakerController.isPlaying)
            return;

        animator.SetFloat("speed", Mathf.Abs(rigidbody2D.velocity.x));
        animator.SetFloat("verticalVelocity", rigidbody2D.velocity.y);
        animator.SetBool("isGrounded", isGrounded);

        RaycastHit2D groundCheck;
        groundCheck = Physics2D.Raycast(transform.position, -Vector2.up, 0.52f, 1 <<LayerMask.NameToLayer("Ground"));
        Debug.DrawRay(transform.position, transform.TransformDirection(-Vector2.up) * groundCheck.distance, Color.red);
        if (groundCheck.collider!=null)
        {
            isGrounded = true;
        }
        else {
            isGrounded = false;
        }

        if (Input.GetKeyDown(KeyCode.UpArrow))
        {
            if (isGrounded)
            {
                animator.SetTrigger("jump");
                jump = true;
                doubleJump = true;
            }
            else if (doubleJump)
            {
                animator.SetTrigger("jump");
                jump = true;
                doubleJump = false;
            }
        }
    }

    private void FixedUpdate()
    {
        if (!MakerController.isPlaying) {
            //editorPosition = transform.position;
            return;
        }
        
        Vector3 fixedFriction = rigidbody2D.velocity;
        fixedFriction.x *= 0.7f;
        if (isGrounded)
        {
            rigidbody2D.velocity = fixedFriction;
        }

        float x = Input.GetAxis("Horizontal");
        float limitedSpeed = Mathf.Clamp(rigidbody2D.velocity.x, -maxSpeed, maxSpeed);

        rigidbody2D.AddForce(Vector2.right * speed * x);
        rigidbody2D.velocity = new Vector2(limitedSpeed, rigidbody2D.velocity.y);

        if (x > 0.1f)
        {
            transform.localScale = new Vector3(1,1,1);
        }

        if (x < -0.1f)
        {
            transform.localScale = new Vector3(-1,1,1);
        }

        if (jump)
        {
            rigidbody2D.velocity = new Vector2(rigidbody2D.velocity.x, 0);
            rigidbody2D.AddForce(Vector2.up * jumpPower, ForceMode2D.Impulse);
            jump = false;
        }
    }

    private void OnCollisionStay2D(Collision2D other)
    {
        if (other.gameObject.tag == "Enemy")
        {
            sprite.color = Color.red;
            life = healthbar.Damage(2f);
            if (life == 0f)
                Destroy(gameObject);
        }
    }

    private void OnCollisionEnter2D(Collision2D other)
    {
        if (other.gameObject.tag == "Heart")
        {
            GameObject heart = other.gameObject;
            healthbar.Heal(30f);
            StartCoroutine(DestroyAfterTime(0.3f, heart));
        }

        if (other.gameObject.tag == "Potion")
        {
            GameObject potion = other.gameObject;
            maxSpeed = 1.21f;
            speed = 23.12f;
            sprite.color = Color.blue;
            StartCoroutine(DestroyAfterTime(0.3f, potion));
            StartCoroutine(BackSpeed(5f));
        }
    }

    private void OnCollisionExit2D(Collision2D other)
    {
        if (other.gameObject.tag == "Enemy")
            sprite.color = Color.white;
    }

    IEnumerator DestroyAfterTime(float time, GameObject obj)
    {
        yield return new WaitForSeconds(time);
        Destroy(obj);
    }

    IEnumerator BackSpeed(float time)
    {
        yield return new WaitForSeconds(time);
        maxSpeed = 4.85f;
        speed = 92.5f;
        sprite.color = Color.white;
    }

    /*private void OnBecameVisible()
    {
        transform.position = editorPosition;
    } */  
}

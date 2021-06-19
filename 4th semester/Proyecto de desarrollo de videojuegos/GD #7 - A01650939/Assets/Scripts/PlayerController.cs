using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class PlayerController : MonoBehaviour
{
    [Header("Player Settings")]
    private float speed = 92.5f;
    private float maxSpeed = 3.99f;
    private bool isGrounded;
    private bool isHooked = false;
    private bool armed = false;
    private Vector2 hookPoint;

    private Rigidbody2D rigidbody2D;
    private DistanceJoint2D rope;
    private LineRenderer line;
    private Animator animator;
     
    [Header("Audio Clips")]
    public AudioClip hookShot;
    public AudioClip gun;

    private AudioSource hookShotSource;
    private AudioSource gunSource;

    private void Start()
    {
        rigidbody2D = GetComponent<Rigidbody2D>();
        animator = GetComponent<Animator>();

        line = gameObject.GetComponent<LineRenderer>();
        line.startWidth = 0.08f;
        line.endWidth = 0.08f;
        line.positionCount = 2;

        hookShotSource = AddAudio(hookShot, false, 0.3f);
        gunSource = AddAudio(gun, false, 0.3f);
    }

    private void Update()
    {
        animator.SetFloat("Speed", Mathf.Abs(rigidbody2D.velocity.x));
        animator.SetBool("isGrounded", isGrounded);
        animator.SetBool("isHooked", isHooked);

        RaycastHit2D groundCheck = Physics2D.Raycast(transform.position, -Vector2.up, 1f, 1 <<LayerMask.NameToLayer("Ground"));
        Debug.DrawRay(transform.position, transform.TransformDirection(-Vector2.up) * groundCheck.distance, Color.yellow);
        if (groundCheck.collider!=null)
        {
            isGrounded = true; 
        }
        else {
            isGrounded = false;
        }

        Vector2 mousePosition = Camera.main.ScreenToWorldPoint(Input.mousePosition);

        line.SetPosition(0, gameObject.transform.position);
        line.startColor = Color.black;
        line.endColor = Color.black;

        if (!isHooked)
            line.SetPosition(1, gameObject.transform.position);

        if (Input.GetMouseButtonDown(0) && isHooked == false && armed == true)
        {
            RaycastHit2D hookObjectCheck = Physics2D.Raycast(mousePosition, Vector2.up, 0.8f, 1 <<LayerMask.NameToLayer("HookObject"));

            if (hookObjectCheck.collider != null)
            {
                hookShotSource.Play();
                hookPoint = mousePosition;
                StartCoroutine(CreateRope(0.5f, mousePosition)); 
            }        
        }
        else if (Input.GetMouseButtonDown(0))
        {
            DestroyImmediate(rope);

            isHooked = false;
        }

    }

    private void FixedUpdate()
    {
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
    }

    IEnumerator CreateRope(float time, Vector2 mousePosition)
    {
        yield return new WaitForSeconds(time);
        rope = gameObject.AddComponent<DistanceJoint2D>();
        rope.connectedAnchor = mousePosition;
        line.SetPosition(1, mousePosition);
        isHooked = true;
    }

    private AudioSource AddAudio(AudioClip clip, bool loop, float volume)
    {
       AudioSource newAudio = gameObject.AddComponent<AudioSource>();
       newAudio.clip = clip;
       newAudio.loop = loop;
       newAudio.volume = volume;

       return newAudio;
    }

    private void OnCollisionEnter2D(Collision2D other)
    {
        if (other.gameObject.tag == "Gun")
        {
            other.gameObject.transform.parent = transform;
            gunSource.Play();
            armed = true;
        }

        if (other.gameObject.tag == "Laser")
        {
            Debug.Log("Hit Laser");
            transform.position = new Vector2(-7.87f, -0.15f);
            DestroyImmediate(rope);
            isHooked = false;
            line.SetPosition(1, gameObject.transform.position);
        }

        if (other.gameObject.tag == "Server")
        {
            SceneManager.LoadScene(0);
        }
    }

    private void OnBecameInvisible()
    {
        transform.position = new Vector2(-7.87f, -0.15f);
        DestroyImmediate(rope);
        isHooked = false;
        line.SetPosition(1, gameObject.transform.position);
    }
}

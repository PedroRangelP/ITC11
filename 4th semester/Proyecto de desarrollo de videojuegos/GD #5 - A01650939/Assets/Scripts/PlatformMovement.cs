using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlatformMovement : MonoBehaviour
{
    [Header("Targets")]
    public GameObject leftTarget;
    public GameObject rightTarget;
    
    private Vector3 currentTarget, right, left;
    private SpriteRenderer rightSprite, leftSprite;
    private Sprite circle;
    private Transform prevParent;
    private float speed = 2.09f;

    private void Start()
    {
        rightSprite = rightTarget.GetComponent<SpriteRenderer>();
        leftSprite = leftTarget.GetComponent<SpriteRenderer>();
        circle = rightSprite.sprite;
    }

    private void FixedUpdate()
    {   
        if (rightTarget.transform != null & leftTarget != null)
        {
            if (!MakerController.isPlaying)
            {
                rightSprite.sprite = circle;
                leftSprite.sprite = circle;
                
                right = rightTarget.transform.position;
                left = leftTarget.transform.position;
                rightTarget.transform.parent = transform;
                leftTarget.transform.parent = transform;

                currentTarget = right;
                return;
            }
            
            if (MakerController.isPlaying)
            {
                rightSprite.sprite = null;
                leftSprite.sprite = null;
            }

            rightTarget.transform.parent = null;
            leftTarget.transform.parent = null;

            Move();
        }
    }

    private void Move()
    {
        if (rightTarget.transform != null & leftTarget != null)
        {
            transform.position = Vector3.MoveTowards(transform.position, currentTarget, speed * Time.deltaTime);
            
            if (transform.position == currentTarget)
            {
                currentTarget = (currentTarget == right) ? left : right;
            }
        }
    }

    private void OnCollisionEnter2D(Collision2D other)
    {
        if (other.gameObject.tag == "Player")
        {
            prevParent = other.gameObject.transform.parent;
            other.gameObject.transform.parent = transform;
        } 
    }

    private void OnCollisionExit2D(Collision2D other)
    {
        if (other.gameObject.tag == "Player")
        {
        other.gameObject.transform.parent = prevParent;
        }
    }
}

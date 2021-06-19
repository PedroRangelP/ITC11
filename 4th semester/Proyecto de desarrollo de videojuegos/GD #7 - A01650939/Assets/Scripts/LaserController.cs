using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LaserController : MonoBehaviour
{
    private BoxCollider2D collider2D;
    private SpriteRenderer renderer;
    private Sprite sprite;
    private AudioSource sound;

    private void Start()
    {
        sound = gameObject.GetComponent<AudioSource>();
        renderer = gameObject.GetComponent<SpriteRenderer>();
        collider2D = gameObject.GetComponent<BoxCollider2D>();
        sprite = renderer.sprite;

        renderer.sprite = null;

        InvokeRepeating("LaserOn", 0f, 6f);
        InvokeRepeating("LaserOff", 3f, 6f);
    }

    private void LaserOn()
    {
        sound.Play();
        renderer.sprite = sprite;
        collider2D.enabled = true;
    }

    private void LaserOff()
    {
        renderer.sprite = null;
        collider2D.enabled = false;
    }
}

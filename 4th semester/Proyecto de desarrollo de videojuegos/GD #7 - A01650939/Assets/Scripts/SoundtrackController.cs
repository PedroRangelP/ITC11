using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SoundtrackController : MonoBehaviour
{
    private AudioSource soundtrack;

    private void Start()
    {
        soundtrack = gameObject.GetComponent<AudioSource>();
        soundtrack.Play();
    }
}

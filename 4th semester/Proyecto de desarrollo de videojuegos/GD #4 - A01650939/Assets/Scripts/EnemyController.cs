using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyController : MonoBehaviour
{
    void Update() {
        gameObject.transform.Translate(new Vector3(0, -0.015f, 0));
    }

    private void OnCollisionEnter2D(Collision2D other) {
        if(other.gameObject.CompareTag("Player")) {
            Destroy(gameObject);
        }

        if(other.gameObject.CompareTag("Limit")) {
            Destroy(gameObject);
        }
    }
}
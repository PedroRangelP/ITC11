using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PBulletController : MonoBehaviour {
    void Update() {
        gameObject.transform.Translate(new Vector3(0, 0.1f, 0));
    }

    private void OnCollisionEnter2D(Collision2D other) {
        if(other.gameObject.CompareTag("Enemy")) {
            Destroy(gameObject);
        }
    }
}

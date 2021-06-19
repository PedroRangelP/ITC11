using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MeteorController : MonoBehaviour {
    
    void Update() {
        gameObject.transform.Translate(new Vector3(0,-0.2f,0));
    }

    private void OnCollisionEnter2D(Collision2D other) {
        if(other.gameObject.CompareTag("Wall")) {
            Destroy(gameObject);
        }
    }
}

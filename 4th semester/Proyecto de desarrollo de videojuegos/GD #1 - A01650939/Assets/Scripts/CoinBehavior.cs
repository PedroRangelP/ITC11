using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CoinBehavior : MonoBehaviour {
    public bool winner = false;
    private SpriteRenderer rend;

    void Start() {
        rend = gameObject.GetComponent<SpriteRenderer>();
    }

    private void OnCollisionStay2D(Collision2D col) {
        if(col.gameObject.tag == "Player") {
            rend.enabled = false;
            winner = true;
        }
    }
}
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class WinnerMsg : MonoBehaviour {
    private CoinBehavior coin;
    private SpriteRenderer rend;

    void Start() {
        coin = GetComponentInParent<CoinBehavior>();
        rend = gameObject.GetComponent<SpriteRenderer>();
    }

    void Update() {
        if(!coin.winner) {
            rend.enabled = false;
        }
        if(coin.winner) {
            rend.enabled = true;
        }
        
    }
}

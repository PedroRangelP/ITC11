using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyController : MonoBehaviour {
    public GameObject bullet, cannon1, cannon2;
    private SpriteRenderer renderer;
    private float life = 100f;
    [SerializeField] private HealthController healthBar;
    
    void Start() {
        renderer = gameObject.GetComponent<SpriteRenderer>();
        InvokeRepeating("Shoot", 0f, 1.5f);
        healthBar.SetSize(life/100f);  
    }

    void Update() {
        gameObject.transform.Translate(new Vector3(0,-0.015f,0));
    }
    
    private void Shoot(){
        Instantiate(bullet, cannon1.transform.position, Quaternion.identity);
        Instantiate(bullet, cannon2.transform.position, Quaternion.identity);
    }

    private void OnCollisionEnter2D(Collision2D other) {
        if(other.gameObject.CompareTag("PBullet")) {
            renderer.color = Color.red;
            life -=10f;
            healthBar.SetSize(life/100f);
        }

        if(life<=0) {
            Destroy(gameObject);
        }

        if(other.gameObject.CompareTag("Wall")) {
            Destroy(gameObject);
        }
    }

    private void OnCollisionExit2D(Collision2D other) {
        renderer.color = Color.white;
    }
}

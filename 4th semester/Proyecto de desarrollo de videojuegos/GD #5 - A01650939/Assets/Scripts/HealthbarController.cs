using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class HealthbarController : MonoBehaviour
{
    public Transform bar;
    private float maxHealth, life;

    public void SetHealth(float maxHealth)
    {
        this.maxHealth = maxHealth;
        life = maxHealth;
    }

    public void Heal(float value) {
        life = Mathf.Clamp(life + value, 0, maxHealth); 
        bar.localScale = new Vector3(life/maxHealth, 1, 1);
    }

    public float Damage(float value)
    {
        life = Mathf.Clamp(life - value, 0, maxHealth);  
        bar.localScale = new Vector3(life/maxHealth, 1, 1);
        return life;
    }
}

using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MoveToTarget : MonoBehaviour
{
    public Transform target;
    private Vector3 targetPosition;
    public float speed;

    private void Start()
    {
        targetPosition = target.position;
    }

    private void Update()
    {
        float distance = Vector3.Distance(transform.position, targetPosition);
        transform.position  = Vector3.Lerp(transform.position, targetPosition, (Time.deltaTime * speed) / distance);
    }
}

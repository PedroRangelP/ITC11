using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CircularMovement : MonoBehaviour
{
    public Transform[] targets;
    private int targetIndex;
    private List<Vector3> _targets = new List<Vector3>();
    private Vector3 _target;
    public float speed;

    private void Start()
    {
        foreach (var target in targets)
        {
            _targets.Add(target.position);
        }
        SetTarget(_targets[targetIndex]);
    }

    private void Update()
    {
        Move();
    }

    private void SetTarget(Vector3 target)
    {
        _target = target;
    }

    private void Move()
    {
        float distance = Vector3.Distance(transform.position, _target);
        if (distance <= 0)
        {
            targetIndex++;
            targetIndex = targetIndex % _targets.Count;
            SetTarget(_targets[targetIndex]);
        }
        else
        {
            transform.position  = Vector3.Lerp(transform.position, _target, (Time.deltaTime * speed) / distance);
        }
    }
}

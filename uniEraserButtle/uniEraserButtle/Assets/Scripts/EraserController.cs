using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EraserController : MonoBehaviour
{
    private Rigidbody rb; // 消しゴムのRigidbody
    private Vector3 touchStartPos; // タップ開始地点のスクリーン座標
    private Vector3 touchEndPos;   // タップ終了地点のスクリーン座標
    private bool isDragging = false; // ドラッグ中かどうかのフラグ

    [Tooltip("はじく力の強さを調整する係数")]
    [SerializeField] private float flickMultiplier = 10f;

    [Tooltip("力が加わるのを現在のターン中の一度だけにするか")]
    [SerializeField] private bool applyForceOnlyOnce = true;
    private bool forceApplied = false; // ターン中に一度力を加えたか

    [Tooltip("停止判定を行う速度の閾値")]
    [SerializeField] private float stopVelocityThreshold = 0.1f;

    void Start()
    {
        // このスクリプトがアタッチされているオブジェクトのRigidbodyを取得
        rb = GetComponent<Rigidbody>();
    }

    void Update()
    {
        // ターン制などで操作を無効化したい場合や、既に力を加えた場合は処理しない
        if (forceApplied && applyForceOnlyOnce)
        {
            return;
        }

        // --- 入力処理 ---
        // Unityエディタ上でのマウス操作
#if UNITY_EDITOR
        HandleMouseInput();
#else
        // スマートフォンでのタッチ操作
        HandleTouchInput();
#endif

        // 速度が閾値以下になったら停止させる
        CheckAndStopIfSlow();
    }

    // マウス入力の処理
    private void HandleMouseInput()
    {
        if (Input.GetMouseButtonDown(0))
        {
            OnDragStart(Input.mousePosition);
        }

        if (Input.GetMouseButtonUp(0))
        {
            OnDragEnd(Input.mousePosition);
        }
    }

    // タッチ入力の処理
    private void HandleTouchInput()
    {
        if (Input.touchCount > 0)
        {
            Touch touch = Input.GetTouch(0);
            switch (touch.phase)
            {
                case TouchPhase.Began:
                    OnDragStart(touch.position);
                    break;
                case TouchPhase.Ended:
                case TouchPhase.Canceled:
                    OnDragEnd(touch.position);
                    break;
            }
        }
    }

    // ドラッグ開始時の処理
    private void OnDragStart(Vector3 screenPos)
    {
        // メインカメラからタップした位置に向かってRayを飛ばす
        Ray ray = Camera.main.ScreenPointToRay(screenPos);
        RaycastHit hit;

        // Rayがコライダーに当たり、かつそれがこのスクリプトがアタッチされたゲームオブジェクトだったら
        if (Physics.Raycast(ray, out hit) && hit.collider.gameObject == this.gameObject)
        {
            isDragging = true;
            touchStartPos = screenPos;
        }
    }

    // ドラッグ終了時の処理
    private void OnDragEnd(Vector3 screenPos)
    {
        if (!isDragging) return; // このオブジェクトをドラッグしていなければ何もしない

        isDragging = false;
        touchEndPos = screenPos;
        Flick();
    }

    // はじく処理
    private void Flick()
    {
        // Rigidbodyが停止していたら物理演算を再開させる
        if (rb.IsSleeping())
        {
            rb.WakeUp();
        }

        // ドラッグした方向と距離を計算
        // 開始地点から終了地点に向かうベクトルなので、(開始座標 - 終了座標) で求める
        Vector3 dragVector = touchStartPos - touchEndPos;

        // z軸の力をy軸の移動量から計算する（カメラが上から見下ろす視点を想定）
        // 不要な場合はこの行を消して、dragVector.z = 0; としても良い
        float forceZ = dragVector.y;

        // 実際に加える力のベクトルを計算 (x, 0, z)
        Vector3 force = new Vector3(dragVector.x, 0, forceZ) * flickMultiplier;

        // 消しゴムに力を加える
        rb.AddForce(force);
        forceApplied = true; // 力を加えたフラグを立てる
    }

    // 次のターンになった時に外部から呼び出すための関数
    public void ResetForNewTurn()
    {
        forceApplied = false;
    }
    
    // 速度が閾値以下になったら停止させる関数
    private void CheckAndStopIfSlow()
    {
        if (rb.velocity.magnitude < stopVelocityThreshold)
        {
            rb.velocity = Vector3.zero; // 速度をゼロにする
            rb.angularVelocity = Vector3.zero; // 角速度もゼロにする (回転も止める場合)
            forceApplied = false; // 力を加えたフラグをリセット
        }
    }
}

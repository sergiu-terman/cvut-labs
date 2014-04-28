(define (problem slidep_1)
    (:domain gripper)
    (:requirements :strips :negative-preconditions)
  	(:objects c11 c12 c21 c22 n1 n2 n3)
    (:init
        (near c11 c12)
        (near c11 c21)

        (near c12 c11)
        (near c12 c22)

        (near c21 c11)
        (near c21 c22)

        (near c22 c12)
        (near c22 c21)

        (have c12 n3)
        (have c21 n2)
        (have c22 n1)

        (empty c11)
    )
    (:goal (and
            (have c11 n1)
            (have c12 n2)
            (have c21 n3)
            (empty c22)
        )
    )
)
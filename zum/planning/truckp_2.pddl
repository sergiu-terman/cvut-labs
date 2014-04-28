(define (problem truckp_2)
    (:domain gripper)
    (:requirements :strips :negative-preconditions)
  	(:objects c1 c2 c3 c4 c5 c6 a b c d e)
    (:init
        (near c1 c2)
        (near c1 c3)
        (near c1 c4)

        (near c2 c1)
        (near c2 c3)

        (near c3 c1)
        (near c3 c2)
        (near c3 c4)
        (near c3 c5)
        (near c3 c6)

        (near c4 c1)
        (near c4 c3)

        (near c5 c3)
        (near c5 c6)

        (near c6 c3)
        (near c6 c5)


        (has c1 a)
        (has c2 b)
        (has c3 c)
        (has c4 d)
        (has c5 e)

        (parked c1)
        (empty)
    )
    (:goal (and
            (has c6 a)
            (has c6 b)
            (has c6 c)
            (has c6 d)
            (has c6 e)

            (parked c6)
        )
    )
)
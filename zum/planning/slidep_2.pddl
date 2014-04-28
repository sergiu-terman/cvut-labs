(define (problem slidep_2)
    (:domain gripper)
    (:requirements :strips :negative-preconditions)
  	(:objects c11 c12 c13
              c21 c22 c23
              c31 c32 c33

              n1 n2 n3 n4 n5 n6 n7 n8)
    (:init
        
        (near c11 c21)(near c11 c12)

        (near c12 c11)
        (near c12 c22)
        (near c12 c13)

        (near c13 c12)
        (near c13 c23)

        (near c21 c11)
        (near c21 c22)
        (near c21 c31)

        (near c22 c12)
        (near c22 c21)
        (near c22 c23)
        (near c22 c32)

        (near c23 c13)
        (near c23 c22)
        (near c23 c33)

        (near c31 c21)
        (near c31 c32)

        (near c32 c31)
        (near c32 c22)
        (near c32 c33)

        (near c33 c23)
        (near c33 c32)


        ; ITEMS PRESENT
        (have c11 n8)
        (have c12 n2)
        (have c13 n7)
        
        (have c21 n5)
        (have c22 n1)
        (have c23 n3)
        
        (have c31 n4)
        (have c32 n6)
        (empty c33)

    )
    (:goal (and
            (have c11 n1)
            (have c12 n2)
            (have c13 n3)

            (have c21 n4)
            (have c22 n5)
            (have c23 n6)

            (have c31 n7)
            (have c32 n8)
        )
    )
)
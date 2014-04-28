(define (domain slide_2)
    (:requirements :strips :negative-preconditions)
    (:predicates
        (have ?cell ?nr)
        (near ?cell1 ?cell2)
        (empty ?cell)
    )


    (:action slide
        :parameters (?cell1 ?cell2 ?nr)
        :precondition (and
            (empty ?cell2)
            (have ?cell1 ?nr)
            (near ?cell1 ?cell2)
        )
        :effect (and
            (empty ?cell1)
            (not (have ?cell1 ?nr))
            (not (empty ?cell2))
            (have ?cell2 ?nr)
        )
    )
)
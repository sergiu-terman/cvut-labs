(define (domain truck_1)
    (:requirements :strips)
    (:predicates
        (has ?who ?what)
        (on-truck ?what)
        (parked ?where)
        (distinct ?x ?y)
        (near ?x ?y)
    )

    (:action load
        :parameters (?what ?place)
        :precondition (and
            (parked ?place)
            (has ?place ?what)
        )
        :effect (and
            (on-truck ?what)
            (not (has ?place ?what))
        )
    )

    (:action unload
        :parameters (?what ?place)
        :precondition (and
            (parked ?place)
            (on-truck ?what)
        )
        :effect (and
            (has ?place ?what)
            (not (on-truck ?what))
        )
    )

    (:action move
        :parameters (?from ?to)
        :precondition (and
            ;(distinct ?from ?to)
            (parked ?from)
            (near ?from ?to)
        )
        :effect (and
            (parked ?to)
            (not (parked ?from))
        )
    )
)
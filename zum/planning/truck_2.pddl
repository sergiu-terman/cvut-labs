(define (domain truck_2)
    (:requirements :strips :negative-preconditions)
    (:predicates
        (has ?who ?what)
        (on-truck ?what)
        (parked ?where)
        (near ?x ?y)
        (empty)
    )

    (:action load
        :parameters (?what ?place)
        :precondition (and
            (empty)
            (parked ?place)
            (has ?place ?what)
        )
        :effect (and
            (not (empty))
            (on-truck ?what)
            (not (has ?place ?what))
        )
    )

    (:action unload
        :parameters (?what ?place)
        :precondition (and
            (not (empty))
            (parked ?place)
            (on-truck ?what)
        )
        :effect (and
            (empty)
            (has ?place ?what)
            (not (on-truck ?what))
        )
    )

    (:action move
        :parameters (?from ?to)
        :precondition (and
            (parked ?from)
            (near ?from ?to)
        )
        :effect (and
            (parked ?to)
            (not (parked ?from))
        )
    )
)
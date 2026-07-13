package hei.school.examen.endpoint.event.consumer.model;

import hei.school.examen.PojaGenerated;
import hei.school.examen.endpoint.event.model.PojaEvent;

@PojaGenerated
public record TypedEvent(String typeName, PojaEvent payload) {}

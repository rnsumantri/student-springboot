package com.springboot.Assembler;

public interface InterfaceAssembler<A, B> {
    A fromDto(B dto);
    B fromEntity(A entity);
}

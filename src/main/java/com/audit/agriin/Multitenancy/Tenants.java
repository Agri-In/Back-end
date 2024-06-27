package com.audit.agriin.Multitenancy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public final class Tenants {
    private Set<String> names;
}

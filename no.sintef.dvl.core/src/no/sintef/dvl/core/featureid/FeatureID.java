package no.sintef.dvl.core.featureid;

import java.util.Objects;

import no.sintef.dvl.core.interfaces.featureid.IFeatureID;

/**
 * Identify a feature uniquely within a Feature tree. This is a value object
 * (immutable)
 */
public class FeatureID implements IFeatureID {

    private final String name;

    public FeatureID(String id) {
        this.name = check(id);
    }

    private String check(String name) {
        if (name == null) {
            throw new NullPointerException("Invalid feature ID ('null' found)");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid feature ID ('' found)");
        }
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FeatureID other = (FeatureID) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return name;
    }

}

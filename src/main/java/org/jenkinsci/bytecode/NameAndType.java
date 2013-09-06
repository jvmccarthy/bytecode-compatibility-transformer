package org.jenkinsci.bytecode;

import org.jenkinsci.constant_pool_scanner.MemberRefConstant;

import java.lang.reflect.Member;

/**
 * {@linkplain Member#getName() Name of a member} and its descriptor.
 *
 * @author Kohsuke Kawaguchi
 */
final class NameAndType {
    final String targetClass;
    final String name;
    final String descriptor;

    NameAndType(String targetClass, String descriptor, String name) {
        this.targetClass = targetClass;
        this.descriptor = descriptor;
        this.name = name;
    }

    NameAndType(MemberRefConstant ref) {
        this(ref.getClazz(), ref.getDescriptor(),ref.getName());
    }

    @Override
    public boolean equals(Object o) {
        NameAndType that = (NameAndType) o;
        return targetClass.equals(that.targetClass) && descriptor.equals(that.descriptor) && name.equals(that.name);

    }

    @Override
    public int hashCode() {
        return 31*name.hashCode() + descriptor.hashCode() + targetClass.hashCode();
    }

    @Override
    public String toString() {
        return targetClass + "." + name+' '+descriptor;
    }
}

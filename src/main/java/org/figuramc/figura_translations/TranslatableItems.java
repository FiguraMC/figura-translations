package org.figuramc.figura_translations;

public sealed interface TranslatableItems {

    Object[] toArray();

    final class Items0 implements TranslatableItems { public static final Items0 INSTANCE = new Items0(); private Items0() {} private static final Object[] EMPTY = new Object[0]; @Override public Object[] toArray() { return EMPTY; } }
    record Items1<A>(A a) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a }; } }
    record Items2<A, B>(A a, B b) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b }; } }
    record Items3<A, B, C>(A a, B b, C c) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b, c }; } }
    record Items4<A, B, C, D>(A a, B b, C c, D d) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b, c, d }; } }
    record Items5<A, B, C, D, E>(A a, B b, C c, D d, E e) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b, c, d, e }; } }
    record Items6<A, B, C, D, E, F>(A a, B b, C c, D d, E e, F f) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b, c, d, e, f }; } }
    record Items7<A, B, C, D, E, F, G>(A a, B b, C c, D d, E e, F f, G g) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b, c, d, e, f, g }; } }
    record Items8<A, B, C, D, E, F, G, H>(A a, B b, C c, D d, E e, F f, G g, H h) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b, c, d, e, f, g, h }; } }
    record Items9<A, B, C, D, E, F, G, H, I>(A a, B b, C c, D d, E e, F f, G g, H h, I i) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b, c, d, e, f, g, h, i }; } }
    record Items10<A, B, C, D, E, F, G, H, I, J>(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b, c, d, e, f, g, h, i, j }; } }
    record Items11<A, B, C, D, E, F, G, H, I, J, K>(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b, c, d, e, f, g, h, i, j, k }; } }
    record Items12<A, B, C, D, E, F, G, H, I, J, K, L>(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b, c, d, e, f, g, h, i, j, k, l }; } }
    record Items13<A, B, C, D, E, F, G, H, I, J, K, L, M>(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b, c, d, e, f, g, h, i, j, k, l, m }; } }
    record Items14<A, B, C, D, E, F, G, H, I, J, K, L, M, N>(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n }; } }
    record Items15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O>(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o }; } }
    record Items16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P>(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p) implements TranslatableItems { @Override public Object[] toArray() { return new Object[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p }; } }

}

package org.figuramc.figura_translations;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Used instead of a minecraft-style "translation string".
 * Translations are statically typed, so you can't accidentally use a non-existent translation, and you must provide
 * the translation with the expected arg types.
 */
public class Translatable<Items extends TranslatableItems> {

    public static final Map<String, Translatable<?>> ALL_TRANSLATABLES = new ConcurrentHashMap<>();

    public final String dotSeparatedForm;

    public String translate(Language language, Items items) {
        if (items == TranslatableItems.Items0.INSTANCE) {
            // Skip formatting, since there are no args. This should be faster
            return FiguraTranslations.getTranslationMap(language).get(this);
        } else {
            // Perform formatting
            return FiguraTranslations.getTranslationMap(language).get(this).formatted(items.toArray());
        }
    }

    private Translatable(String dotSeparatedForm) {
        this.dotSeparatedForm = dotSeparatedForm;
        if (ALL_TRANSLATABLES.putIfAbsent(dotSeparatedForm, this) != null)
            throw new IllegalArgumentException("Translatable item with key \"" + dotSeparatedForm + "\" already exists");
        FiguraTranslations.clearTranslationCache(); // Clear translation cache, now that we have a new one created
    }

    // Helper methods to translate translatable items and provide them with args

    public static String translate(Language language, Translatable<TranslatableItems.Items0> translatable) { return translatable.translate(language, TranslatableItems.Items0.INSTANCE); }
    public static <A> String translate(Language language, Translatable<TranslatableItems.Items1<A>> translatable, A arg1) { return translatable.translate(language, new TranslatableItems.Items1<>(arg1)); }
    public static <A, B> String translate(Language language, Translatable<TranslatableItems.Items2<A, B>> translatable, A arg1, B arg2) { return translatable.translate(language, new TranslatableItems.Items2<>(arg1, arg2)); }
    public static <A, B, C> String translate(Language language, Translatable<TranslatableItems.Items3<A, B, C>> translatable, A arg1, B arg2, C arg3) { return translatable.translate(language, new TranslatableItems.Items3<>(arg1, arg2, arg3)); }
    public static <A, B, C, D> String translate(Language language, Translatable<TranslatableItems.Items4<A, B, C, D>> translatable, A arg1, B arg2, C arg3, D arg4) { return translatable.translate(language, new TranslatableItems.Items4<>(arg1, arg2, arg3, arg4)); }
    public static <A, B, C, D, E> String translate(Language language, Translatable<TranslatableItems.Items5<A, B, C, D, E>> translatable, A arg1, B arg2, C arg3, D arg4, E arg5) { return translatable.translate(language, new TranslatableItems.Items5<>(arg1, arg2, arg3, arg4, arg5)); }
    public static <A, B, C, D, E, F> String translate(Language language, Translatable<TranslatableItems.Items6<A, B, C, D, E, F>> translatable, A arg1, B arg2, C arg3, D arg4, E arg5, F arg6) { return translatable.translate(language, new TranslatableItems.Items6<>(arg1, arg2, arg3, arg4, arg5, arg6)); }
    public static <A, B, C, D, E, F, G> String translate(Language language, Translatable<TranslatableItems.Items7<A, B, C, D, E, F, G>> translatable, A arg1, B arg2, C arg3, D arg4, E arg5, F arg6, G arg7) { return translatable.translate(language, new TranslatableItems.Items7<>(arg1, arg2, arg3, arg4, arg5, arg6, arg7)); }
    public static <A, B, C, D, E, F, G, H> String translate(Language language, Translatable<TranslatableItems.Items8<A, B, C, D, E, F, G, H>> translatable, A arg1, B arg2, C arg3, D arg4, E arg5, F arg6, G arg7, H arg8) { return translatable.translate(language, new TranslatableItems.Items8<>(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8)); }
    public static <A, B, C, D, E, F, G, H, I> String translate(Language language, Translatable<TranslatableItems.Items9<A, B, C, D, E, F, G, H, I>> translatable, A arg1, B arg2, C arg3, D arg4, E arg5, F arg6, G arg7, H arg8, I arg9) { return translatable.translate(language, new TranslatableItems.Items9<>(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9)); }
    public static <A, B, C, D, E, F, G, H, I, J> String translate(Language language, Translatable<TranslatableItems.Items10<A, B, C, D, E, F, G, H, I, J>> translatable, A arg1, B arg2, C arg3, D arg4, E arg5, F arg6, G arg7, H arg8, I arg9, J arg10) { return translatable.translate(language, new TranslatableItems.Items10<>(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10)); }
    public static <A, B, C, D, E, F, G, H, I, J, K> String translate(Language language, Translatable<TranslatableItems.Items11<A, B, C, D, E, F, G, H, I, J, K>> translatable, A arg1, B arg2, C arg3, D arg4, E arg5, F arg6, G arg7, H arg8, I arg9, J arg10, K arg11) { return translatable.translate(language, new TranslatableItems.Items11<>(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11)); }
    public static <A, B, C, D, E, F, G, H, I, J, K, L> String translate(Language language, Translatable<TranslatableItems.Items12<A, B, C, D, E, F, G, H, I, J, K, L>> translatable, A arg1, B arg2, C arg3, D arg4, E arg5, F arg6, G arg7, H arg8, I arg9, J arg10, K arg11, L arg12) { return translatable.translate(language, new TranslatableItems.Items12<>(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12)); }
    public static <A, B, C, D, E, F, G, H, I, J, K, L, M> String translate(Language language, Translatable<TranslatableItems.Items13<A, B, C, D, E, F, G, H, I, J, K, L, M>> translatable, A arg1, B arg2, C arg3, D arg4, E arg5, F arg6, G arg7, H arg8, I arg9, J arg10, K arg11, L arg12, M arg13) { return translatable.translate(language, new TranslatableItems.Items13<>(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13)); }
    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N> String translate(Language language, Translatable<TranslatableItems.Items14<A, B, C, D, E, F, G, H, I, J, K, L, M, N>> translatable, A arg1, B arg2, C arg3, D arg4, E arg5, F arg6, G arg7, H arg8, I arg9, J arg10, K arg11, L arg12, M arg13, N arg14) { return translatable.translate(language, new TranslatableItems.Items14<>(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14)); }
    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> String translate(Language language, Translatable<TranslatableItems.Items15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O>> translatable, A arg1, B arg2, C arg3, D arg4, E arg5, F arg6, G arg7, H arg8, I arg9, J arg10, K arg11, L arg12, M arg13, N arg14, O arg15) { return translatable.translate(language, new TranslatableItems.Items15<>(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15)); }
    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> String translate(Language language, Translatable<TranslatableItems.Items16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P>> translatable, A arg1, B arg2, C arg3, D arg4, E arg5, F arg6, G arg7, H arg8, I arg9, J arg10, K arg11, L arg12, M arg13, N arg14, O arg15, P arg16) { return translatable.translate(language, new TranslatableItems.Items16<>(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16)); }

    // Helper methods to create Translatable items

    public static Translatable<TranslatableItems.Items0> create(String dotSeparated) { return new Translatable<>(dotSeparated); }
    public static <A> Translatable<TranslatableItems.Items1<A>> create(String dotSeparated, Class<A> arg1) { return new Translatable<>(dotSeparated); }
    public static <A, B> Translatable<TranslatableItems.Items2<A, B>> create(String dotSeparated, Class<A> arg1, Class<B> arg2) { return new Translatable<>(dotSeparated); }
    public static <A, B, C> Translatable<TranslatableItems.Items3<A, B, C>> create(String dotSeparated, Class<A> arg1, Class<B> arg2, Class<C> arg3) { return new Translatable<>(dotSeparated); }
    public static <A, B, C, D> Translatable<TranslatableItems.Items4<A, B, C, D>> create(String dotSeparated, Class<A> arg1, Class<B> arg2, Class<C> arg3, Class<D> arg4) { return new Translatable<>(dotSeparated); }
    public static <A, B, C, D, E> Translatable<TranslatableItems.Items5<A, B, C, D, E>> create(String dotSeparated, Class<A> arg1, Class<B> arg2, Class<C> arg3, Class<D> arg4, Class<E> arg5) { return new Translatable<>(dotSeparated); }
    public static <A, B, C, D, E, F> Translatable<TranslatableItems.Items6<A, B, C, D, E, F>> create(String dotSeparated, Class<A> arg1, Class<B> arg2, Class<C> arg3, Class<D> arg4, Class<E> arg5, Class<F> arg6) { return new Translatable<>(dotSeparated); }
    public static <A, B, C, D, E, F, G> Translatable<TranslatableItems.Items7<A, B, C, D, E, F, G>> create(String dotSeparated, Class<A> arg1, Class<B> arg2, Class<C> arg3, Class<D> arg4, Class<E> arg5, Class<F> arg6, Class<G> arg7) { return new Translatable<>(dotSeparated); }
    public static <A, B, C, D, E, F, G, H> Translatable<TranslatableItems.Items8<A, B, C, D, E, F, G, H>> create(String dotSeparated, Class<A> arg1, Class<B> arg2, Class<C> arg3, Class<D> arg4, Class<E> arg5, Class<F> arg6, Class<G> arg7, Class<H> arg8) { return new Translatable<>(dotSeparated); }
    public static <A, B, C, D, E, F, G, H, I> Translatable<TranslatableItems.Items9<A, B, C, D, E, F, G, H, I>> create(String dotSeparated, Class<A> arg1, Class<B> arg2, Class<C> arg3, Class<D> arg4, Class<E> arg5, Class<F> arg6, Class<G> arg7, Class<H> arg8, Class<I> arg9) { return new Translatable<>(dotSeparated); }
    public static <A, B, C, D, E, F, G, H, I, J> Translatable<TranslatableItems.Items10<A, B, C, D, E, F, G, H, I, J>> create(String dotSeparated, Class<A> arg1, Class<B> arg2, Class<C> arg3, Class<D> arg4, Class<E> arg5, Class<F> arg6, Class<G> arg7, Class<H> arg8, Class<I> arg9, Class<J> arg10) { return new Translatable<>(dotSeparated); }
    public static <A, B, C, D, E, F, G, H, I, J, K> Translatable<TranslatableItems.Items11<A, B, C, D, E, F, G, H, I, J, K>> create(String dotSeparated, Class<A> arg1, Class<B> arg2, Class<C> arg3, Class<D> arg4, Class<E> arg5, Class<F> arg6, Class<G> arg7, Class<H> arg8, Class<I> arg9, Class<J> arg10, Class<K> arg11) { return new Translatable<>(dotSeparated); }
    public static <A, B, C, D, E, F, G, H, I, J, K, L> Translatable<TranslatableItems.Items12<A, B, C, D, E, F, G, H, I, J, K, L>> create(String dotSeparated, Class<A> arg1, Class<B> arg2, Class<C> arg3, Class<D> arg4, Class<E> arg5, Class<F> arg6, Class<G> arg7, Class<H> arg8, Class<I> arg9, Class<J> arg10, Class<K> arg11, Class<L> arg12) { return new Translatable<>(dotSeparated); }
    public static <A, B, C, D, E, F, G, H, I, J, K, L, M> Translatable<TranslatableItems.Items13<A, B, C, D, E, F, G, H, I, J, K, L, M>> create(String dotSeparated, Class<A> arg1, Class<B> arg2, Class<C> arg3, Class<D> arg4, Class<E> arg5, Class<F> arg6, Class<G> arg7, Class<H> arg8, Class<I> arg9, Class<J> arg10, Class<K> arg11, Class<L> arg12, Class<M> arg13) { return new Translatable<>(dotSeparated); }
    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N> Translatable<TranslatableItems.Items14<A, B, C, D, E, F, G, H, I, J, K, L, M, N>> create(String dotSeparated, Class<A> arg1, Class<B> arg2, Class<C> arg3, Class<D> arg4, Class<E> arg5, Class<F> arg6, Class<G> arg7, Class<H> arg8, Class<I> arg9, Class<J> arg10, Class<K> arg11, Class<L> arg12, Class<M> arg13, Class<N> arg14) { return new Translatable<>(dotSeparated); }
    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> Translatable<TranslatableItems.Items15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O>> create(String dotSeparated, Class<A> arg1, Class<B> arg2, Class<C> arg3, Class<D> arg4, Class<E> arg5, Class<F> arg6, Class<G> arg7, Class<H> arg8, Class<I> arg9, Class<J> arg10, Class<K> arg11, Class<L> arg12, Class<M> arg13, Class<N> arg14, Class<O> arg15) { return new Translatable<>(dotSeparated); }
    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> Translatable<TranslatableItems.Items16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P>> create(String dotSeparated, Class<A> arg1, Class<B> arg2, Class<C> arg3, Class<D> arg4, Class<E> arg5, Class<F> arg6, Class<G> arg7, Class<H> arg8, Class<I> arg9, Class<J> arg10, Class<K> arg11, Class<L> arg12, Class<M> arg13, Class<N> arg14, Class<O> arg15, Class<P> arg16) { return new Translatable<>(dotSeparated); }

}

package com.hucet.tyler.quick.media.inject;

import com.hucet.tyler.quick.media.utils.ViewModelFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import kotlin.annotation.MustBeDocumented;

@Module
public abstract class ViewModelModule {
    @Binds
    @Singleton
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

//    @Binds
//    @IntoMap
//    @Singleton
//    @ViewModelKey(MemoViewModel.class)
//    abstract ViewModel bindMemoViewModel(MemoViewModel memoViewModel);

    @MustBeDocumented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    public @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }
}
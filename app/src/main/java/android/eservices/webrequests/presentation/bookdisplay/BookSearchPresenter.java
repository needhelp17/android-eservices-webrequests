package android.eservices.webrequests.presentation.bookdisplay;

import android.eservices.webrequests.data.api.model.BookSearchResponse;
import android.eservices.webrequests.data.bookdisplay.BookDisplayRepository;
import android.eservices.webrequests.presentation.bookdisplay.search.BookSearchContract;
import android.eservices.webrequests.presentation.bookdisplay.search.fragment.SearchFragment;
import android.eservices.webrequests.presentation.bookdisplay.search.mapper.BookToViewModelMapper;

import java.util.BitSet;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class BookSearchPresenter implements BookSearchContract.Presenter {

    private CompositeDisposable compositeDisposable;
    private BookDisplayRepository bookDisplayRepository;
    private BookSearchContract.View view;
    private BookToViewModelMapper bookToViewModelMapper;

    @Override
    public void searchBooks(String s) {
        compositeDisposable.clear();
        compositeDisposable.add(bookDisplayRepository.getBookSearchResponse(s)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<BookSearchResponse>() {

                    @Override
                    public void onSuccess(BookSearchResponse bookSearchResponse) {
                        // work with the resulting todos
                        view.displayBooks(bookToViewModelMapper.map(bookSearchResponse.getBookList()));
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e);
                    }
                }));
    }

    public BookSearchPresenter(BookDisplayRepository bookDisplayRepository, BookToViewModelMapper bookToViewModelMapper) {
        this.bookDisplayRepository = bookDisplayRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.bookToViewModelMapper = bookToViewModelMapper;
    }



    @Override
    public void attachView(BookSearchContract.View view) {
        this.view = view;
    }

    @Override
    public void cancelSubscription() {
        compositeDisposable.clear();
    }

    @Override
    public void addBookToFavorite(String bookId) {

    }

    @Override
    public void removeBookFromFavorites(String bookId) {

    }

    @Override
    public void detachView() {

    }
}

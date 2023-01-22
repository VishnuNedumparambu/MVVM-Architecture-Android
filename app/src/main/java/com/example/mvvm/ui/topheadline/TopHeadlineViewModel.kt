package com.example.mvvm.ui.topheadline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.model.Article
import com.example.mvvm.data.repository.TopHeadlineRepository
import com.example.mvvm.utils.AppConstant.COUNTRY
import com.example.mvvm.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class TopHeadlineViewModel(private val topHeadlineRepository: TopHeadlineRepository):ViewModel() {
    private val _articleList = MutableStateFlow<Resource<List<Article>>>(Resource.loading())
    val articleList:  StateFlow<Resource<List<Article>>>  = _articleList

    init {
        fetchTopHeadlines()
    }


    private fun fetchTopHeadlines(){
        viewModelScope.launch {
            topHeadlineRepository.getTopHeadlines(COUNTRY)
                .catch { e ->
                    _articleList.value=Resource.error(e.toString())
                }
                .collect{
                    _articleList.value=Resource.success(it)
                }
        }
    }
}
'use strict'

function HttpUtils(baseUrl) {
    this.Axios = null;
    this.init(baseUrl);  //构造函数的入口；
}

HttpUtils.prototype = {
    constructor: HttpUtils, //必须重新定义原型指向
    // 初始化方法
    init: function (baseUrl) {
        if (!axios) {
            throw new Error("axios not imported, please check!")
        }
        this.Axios = axios.create({
            baseURL: baseUrl,
            timeout: 5000,
            withCredentials: true// 是否允许带cookie这些
        })
        // 响应拦截（配置请求回来的信息）
        this.Axios.interceptors.response.use(
            function(response) {
                // 处理响应数据
                return response
            },
            function(error) {
                // 处理响应失败
                console.log(error)
                return Promise.reject(error)
            }
        )
        return this;   //链式操作的核心，就可以在
    },

    get: function (url, params = {}) {
        return new Promise((resolve, reject) => {
            this.Axios.get(url, {
                params
            })
                .then(response => {
                    resolve(response.data)
                })
                .catch(err => {
                    reject(err)
                })
        })
    },
    post: function (url, params = {}) {
        return new Promise((resolve, reject) => {
            this.Axios.post(url, params).then(
                response => {
                    resolve(response.data)
                },
                err => {
                    reject(err)
                }
            )
        })
    },
    put: function (url, params = {}) {
        return new Promise((resolve, reject) => {
            this.Axios.put(url, params).then(
                response => {
                    resolve(response.data)
                },
                err => {
                    reject(err)
                }
            )
        })
    },
    del: function (url, params = {}) {
        return new Promise((resolve, reject) => {
            this.Axios.delete(url, {
                params
            })
                .then(response => {
                    resolve(response.data)
                })
                .catch(err => {
                    reject(err)
                })
        })
    },
    err: function (error) {
        if (error && error.response) {
            if (error.response.data) {
                return error.response.data
            }
            return error.message
        }
        return ''
    }

}
package com.gmvalentino.entities

sealed class ErrorEntity(
    open val throwable: Throwable
) : Throwable(throwable) {

    data class Network(
        override val throwable: Throwable
    ) : ErrorEntity(throwable)

    data class NotFound(
        override val throwable: Throwable
    ) : ErrorEntity(throwable)

    data class Unauthorized(
        override val throwable: Throwable
    ) : ErrorEntity(throwable)

    data class Forbidden(
        override val throwable: Throwable
    ) : ErrorEntity(throwable)

    data class RequestTimeout(
        override val throwable: Throwable
    ) : ErrorEntity(throwable)

    data class UpgradeRequired(
        override val throwable: Throwable
    ) : ErrorEntity(throwable)

    data class Internal(
        override val throwable: Throwable
    ) : ErrorEntity(throwable)

    data class Unavailable(
        override val throwable: Throwable
    ) : ErrorEntity(throwable)

    data class BadRequest(
        override val throwable: Throwable
    ) : ErrorEntity(throwable)

    data class Unknown(
        override val throwable: Throwable
    ) : ErrorEntity(throwable)

    // ここで他のエラーを追加します
}

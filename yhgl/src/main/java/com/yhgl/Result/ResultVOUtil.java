package com.yhgl.Result;

public class ResultVOUtil {
    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(0, "成功", data);
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(ResultEnum resultEnum) {
        return new ResultVO(resultEnum.getCode(), resultEnum.getMessage(), null);
    }
}

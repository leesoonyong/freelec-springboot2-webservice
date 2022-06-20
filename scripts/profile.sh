#!/usr/bin/env bash

# 쉬고있는 profile 찾기: real1이 사용중이면 real2가 쉬고있고, 반대면 real1이 쉬고있음
function find_idel_profile()
{
    RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}"
                                            http://localhost:/profile)
    if[ ${RESPONSE_CODE} -ge 400] #400보다 크면(즉, 40x/50x 에러모두 포함)

    then
      CURRENT_PROFILE=real2
    else
      CURRENT_PROFILE=$(curl -s http://localhost/profile)
    fi

    if[ ${CURRENT ]
}
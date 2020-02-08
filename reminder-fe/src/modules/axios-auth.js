import axios from 'axios'
import store from '@/modules/store'
import { StringUtils } from '@/utils/common'

/**
 * @description axios interceptor를 통한 http hader token 적용
 */
axios.interceptors.request.use((config) => {
    // 로그인 유저 token 조회
    const token = store.getters['member/getAuthorizeToken'];

    if (StringUtils.isNotEmpty(token)) {
      config.headers.Authorization = `Bearer ${token}`
    }

    return config
});

export default axios;
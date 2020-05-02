import axios from '@/modules/axios-auth'

const MEMBER_API = '/api/members';

/**
 * 회원 API 서비스
 * 
 * @author hyungyu.lee
 */
export default {
  /**
   * 사용자 프로필 조회
   * 
   * @param memberId 사용자 ID
   * @returns `Promise`
   */
  getProfile(memberId) {
    return axios.get(`${MEMBER_API}/${memberId}`);
  }
}

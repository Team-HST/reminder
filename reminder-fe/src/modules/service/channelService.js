import axios from '@/modules/axios-auth'

// const API = '/api/channels';
const MEMBER_API = '/api/members';

/**
 * 채널 API 서비스
 * 
 * @author hyungyu.lee
 */
export default {
  /**
   * 사용자가 생성한 채널 목록 조회
   * 
   * @param memberId 사용자 ID
   * @returns `Promise`
   */
  getCreatedChannels(memberId) {
    return axios.get(`${MEMBER_API}/${memberId}/channels/created`);
  },
  /**
   * 사용자가 소속된 채널 목록 조회
   * 
   * @param memberId 사용자 ID
   * @returns `Promise`
   */
  getInvolvedChannels(memberId) {
    return axios.get(`${MEMBER_API}/${memberId}/channels/involved`);
  },
}

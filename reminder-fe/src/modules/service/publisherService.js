import axios from '@/modules/axios-auth'

const API = '/api/publishers';

/**
 * 발행자 API 서비스
 * 
 * @author hyungyu.lee
 */
export default {
  /**
   * 사용자의 발행자 목록 조회
   * 
   * @param memberId 사용자 ID
   * @returns `Promise`
   */
  getPublishers(memberId) {
    return axios.get(`${API}/by-member/${memberId}`);
  },
  /**
   * 발행자 등록
   * 
   * @param publisher 발행자 Item
   * @returns `Promise`
   */
  createPublisher(publisher) {
    return axios.post(`${API}`, publisher);
  },
  /**
   * 발행자 삭제
   * 
   * @param publisherIds 삭제할 발행자 ID 목록
   * @returns `Promise`
   */
  deletePublisher(publisherIds) {
    return axios.delete(`${API}`, {data: publisherIds})
  }
}

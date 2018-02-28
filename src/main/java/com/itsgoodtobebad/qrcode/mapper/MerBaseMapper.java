package com.itsgoodtobebad.qrcode.mapper;

import com.itsgoodtobebad.qrcode.dto.MerBase;

/**
 * @author liliangxi.
 *         Created on 2018/2/23.
 */
public interface MerBaseMapper {

    MerBase queryMerchantByMchtPhone(String mchtPhone);

    /** 根据联系人手机号从商户表删除商户信息 */
    void deleteMerchantFromMerBaseByMchtPhone(String mchtPhone);

    /** 根据联系人手机号从商户审批表删除商户信息 */
    void deleteMerchantFromMerBaseApprovalByMchtPhone(String mchtPhone);

    /** 根据merbaseid从Mer_Picture表中删除商户图片信息 */
    void deletePicFromMerPictureByMerBaseId(String merbaseid);

    /** 根据merbaseapprovalid从Mer_Base_Approval表中删除商户图片信息 */
    void deltePicFromMerPictureApprovalByMerBaseApprovalId(String merbaseapprovalid);
}
